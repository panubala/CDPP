  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = (+(-(+(-(2)))) + -(+(-(2))))
          # Emitting (+(-(+(-(2)))) + -(+(-(2))))
            # Emitting +(-(+(-(2))))
              # Emitting -(+(-(2)))
                # Emitting +(-(2))
                  # Emitting -(2)
                    # Emitting 2
                    movl $2, %edi
                  negl %edi
              negl %edi
            # Emitting -(+(-(2)))
              # Emitting +(-(2))
                # Emitting -(2)
                  # Emitting 2
                  movl $2, %esi
                negl %esi
            negl %esi
          addl %esi, %edi
          # Emitting i0
          subl $4, %esp
        movl %edi, -4(%ebp)
        # Emitting i1 = (-(+(-(+(2)))) - +(-(+(2))))
          # Emitting (-(+(-(+(2)))) - +(-(+(2))))
            # Emitting -(+(-(+(2))))
              # Emitting +(-(+(2)))
                # Emitting -(+(2))
                  # Emitting +(2)
                    # Emitting 2
                    movl $2, %esi
                negl %esi
            negl %esi
            # Emitting +(-(+(2)))
              # Emitting -(+(2))
                # Emitting +(2)
                  # Emitting 2
                  movl $2, %edi
              negl %edi
          subl %edi, %esi
          # Emitting i1
          subl $4, %esp
        movl %esi, -8(%ebp)
        # Emitting write(((-(+(5)) - +(5)) - +(5)))
          # Emitting ((-(+(5)) - +(5)) - +(5))
            # Emitting (-(+(5)) - +(5))
              # Emitting -(+(5))
                # Emitting +(5)
                  # Emitting 5
                  movl $5, %edi
              negl %edi
              # Emitting +(5)
                # Emitting 5
                movl $5, %esi
            subl %esi, %edi
            # Emitting +(5)
              # Emitting 5
              movl $5, %esi
          subl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write(((+(-(5)) + -(5)) + -(5)))
          # Emitting ((+(-(5)) + -(5)) + -(5))
            # Emitting (+(-(5)) + -(5))
              # Emitting +(-(5))
                # Emitting -(5)
                  # Emitting 5
                  movl $5, %edi
                negl %edi
              # Emitting -(5)
                # Emitting 5
                movl $5, %esi
              negl %esi
            addl %esi, %edi
            # Emitting -(5)
              # Emitting 5
              movl $5, %esi
            negl %esi
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write(((((-(1) * +(-(1))) / +(-(1))) * -(-(1))) / -(-(1))))
          # Emitting ((((-(1) * +(-(1))) / +(-(1))) * -(-(1))) / -(-(1)))
            # Emitting (((-(1) * +(-(1))) / +(-(1))) * -(-(1)))
              # Emitting ((-(1) * +(-(1))) / +(-(1)))
                # Emitting (-(1) * +(-(1)))
                  # Emitting +(-(1))
                    # Emitting -(1)
                      # Emitting 1
                      movl $1, %edi
                    negl %edi
                  # Emitting -(1)
                    # Emitting 1
                    movl $1, %esi
                  negl %esi
                imull %edi, %esi
                # Emitting +(-(1))
                  # Emitting -(1)
                    # Emitting 1
                    movl $1, %edi
                  negl %edi
              movl %esi, %eax
              cltd
              idivl %edi
              movl %eax, %esi
              # Emitting -(-(1))
                # Emitting -(1)
                  # Emitting 1
                  movl $1, %edi
                negl %edi
              negl %edi
            imull %edi, %esi
            # Emitting -(-(1))
              # Emitting -(1)
                # Emitting 1
                movl $1, %edi
              negl %edi
            negl %edi
          movl %esi, %eax
          cltd
          idivl %edi
          movl %eax, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
