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
          # Emitting i0
          subl $4, %esp
          # Emitting (+(-(+(-(2)))) + -(+(-(2))))
            # Emitting +(-(+(-(2))))
              # Emitting -(+(-(2)))
                # Emitting +(-(2))
                  # Emitting -(2)
                    # Emitting 2
                    movl $2, %esi
                  negl %esi
              negl %esi
          pushl %esi
            # Emitting -(+(-(2)))
              # Emitting +(-(2))
                # Emitting -(2)
                  # Emitting 2
                  movl $2, %esi
                negl %esi
            negl %esi
          movl -8(%ebp), %edx
          addl $4, %esp
          addl %esi, %edx
        movl %edx, -4(%ebp)
        # Emitting i1 = (-(+(-(+(2)))) - +(-(+(2))))
          # Emitting i1
          subl $4, %esp
          # Emitting (-(+(-(+(2)))) - +(-(+(2))))
            # Emitting -(+(-(+(2))))
              # Emitting +(-(+(2)))
                # Emitting -(+(2))
                  # Emitting +(2)
                    # Emitting 2
                    movl $2, %edx
                negl %edx
            negl %edx
          pushl %edx
            # Emitting +(-(+(2)))
              # Emitting -(+(2))
                # Emitting +(2)
                  # Emitting 2
                  movl $2, %edx
              negl %edx
          movl -12(%ebp), %esi
          addl $4, %esp
          subl %edx, %esi
        movl %esi, -8(%ebp)
        # Emitting write(((-(+(5)) - +(5)) - +(5)))
          # Emitting ((-(+(5)) - +(5)) - +(5))
            # Emitting (-(+(5)) - +(5))
              # Emitting -(+(5))
                # Emitting +(5)
                  # Emitting 5
                  movl $5, %edi
              negl %edi
            pushl %edi
              # Emitting +(5)
                # Emitting 5
                movl $5, %edi
            movl -12(%ebp), %esi
            addl $4, %esp
            subl %edi, %esi
          pushl %esi
            # Emitting +(5)
              # Emitting 5
              movl $5, %esi
          movl -12(%ebp), %edi
          addl $4, %esp
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
            pushl %edi
              # Emitting -(5)
                # Emitting 5
                movl $5, %edi
              negl %edi
            movl -12(%ebp), %esi
            addl $4, %esp
            addl %edi, %esi
          pushl %esi
            # Emitting -(5)
              # Emitting 5
              movl $5, %esi
            negl %esi
          movl -12(%ebp), %edi
          addl $4, %esp
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
                  # Emitting -(1)
                    # Emitting 1
                    movl $1, %edi
                  negl %edi
                pushl %edi
                  # Emitting +(-(1))
                    # Emitting -(1)
                      # Emitting 1
                      movl $1, %edi
                    negl %edi
                movl -12(%ebp), %esi
                addl $4, %esp
                imull %edi, %esi
              pushl %esi
                # Emitting +(-(1))
                  # Emitting -(1)
                    # Emitting 1
                    movl $1, %esi
                  negl %esi
              movl -12(%ebp), %edi
              addl $4, %esp
              movl %edi, %eax
              cltd
              idivl %esi
              movl %eax, %edi
            pushl %edi
              # Emitting -(-(1))
                # Emitting -(1)
                  # Emitting 1
                  movl $1, %edi
                negl %edi
              negl %edi
            movl -12(%ebp), %esi
            addl $4, %esp
            imull %edi, %esi
          pushl %esi
            # Emitting -(-(1))
              # Emitting -(1)
                # Emitting 1
                movl $1, %esi
              negl %esi
            negl %esi
          movl -12(%ebp), %edi
          addl $4, %esp
          movl %edi, %eax
          cltd
          idivl %esi
          movl %eax, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
