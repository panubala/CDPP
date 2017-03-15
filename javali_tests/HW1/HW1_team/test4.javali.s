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
        # Emitting i0 = 5
          # Emitting 5
          movl $5, %edi
          # Emitting i0
          subl $4, %esp
        movl %edi, -4(%ebp)
        # Emitting write(+(i0))
          # Emitting +(i0)
            # Emitting i0
            movl -4(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write(-(i0))
          # Emitting -(i0)
            # Emitting i0
            movl -4(%ebp), %esi
          negl %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((-(1) * +(i0)))
          # Emitting (-(1) * +(i0))
            # Emitting -(1)
              # Emitting 1
              movl $1, %esi
            negl %esi
            # Emitting +(i0)
              # Emitting i0
              movl -4(%ebp), %edi
          imull %edi, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((-(1) * -(i0)))
          # Emitting (-(1) * -(i0))
            # Emitting -(1)
              # Emitting 1
              movl $1, %esi
            negl %esi
            # Emitting -(i0)
              # Emitting i0
              movl -4(%ebp), %edi
            negl %edi
          imull %edi, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting i1 = 10
          # Emitting 10
          movl $10, %esi
          # Emitting i1
          subl $4, %esp
        movl %esi, -8(%ebp)
        # Emitting write((+(i0) + -(i1)))
          # Emitting (+(i0) + -(i1))
            # Emitting +(i0)
              # Emitting i0
              movl -4(%ebp), %edi
            # Emitting -(i1)
              # Emitting i1
              movl -8(%ebp), %esi
            negl %esi
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((-(i0) + -(i1)))
          # Emitting (-(i0) + -(i1))
            # Emitting -(i0)
              # Emitting i0
              movl -4(%ebp), %edi
            negl %edi
            # Emitting -(i1)
              # Emitting i1
              movl -8(%ebp), %esi
            negl %esi
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((-(-(i0)) + -(i1)))
          # Emitting (-(-(i0)) + -(i1))
            # Emitting -(-(i0))
              # Emitting -(i0)
                # Emitting i0
                movl -4(%ebp), %edi
              negl %edi
            negl %edi
            # Emitting -(i1)
              # Emitting i1
              movl -8(%ebp), %esi
            negl %esi
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((+(+(i0)) + -(i1)))
          # Emitting (+(+(i0)) + -(i1))
            # Emitting +(+(i0))
              # Emitting +(i0)
                # Emitting i0
                movl -4(%ebp), %edi
            # Emitting -(i1)
              # Emitting i1
              movl -8(%ebp), %esi
            negl %esi
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((((+(-(+(-(+(-(i0)))))) + -(+(-(+(-(i1)))))) + -(+(-(+(-(i0)))))) + -(+(-(+(-(i1)))))))
          # Emitting (((+(-(+(-(+(-(i0)))))) + -(+(-(+(-(i1)))))) + -(+(-(+(-(i0)))))) + -(+(-(+(-(i1))))))
            # Emitting ((+(-(+(-(+(-(i0)))))) + -(+(-(+(-(i1)))))) + -(+(-(+(-(i0))))))
              # Emitting (+(-(+(-(+(-(i0)))))) + -(+(-(+(-(i1))))))
                # Emitting +(-(+(-(+(-(i0))))))
                  # Emitting -(+(-(+(-(i0)))))
                    # Emitting +(-(+(-(i0))))
                      # Emitting -(+(-(i0)))
                        # Emitting +(-(i0))
                          # Emitting -(i0)
                            # Emitting i0
                            movl -4(%ebp), %edi
                          negl %edi
                      negl %edi
                  negl %edi
                # Emitting -(+(-(+(-(i1)))))
                  # Emitting +(-(+(-(i1))))
                    # Emitting -(+(-(i1)))
                      # Emitting +(-(i1))
                        # Emitting -(i1)
                          # Emitting i1
                          movl -8(%ebp), %esi
                        negl %esi
                    negl %esi
                negl %esi
              addl %esi, %edi
              # Emitting -(+(-(+(-(i0)))))
                # Emitting +(-(+(-(i0))))
                  # Emitting -(+(-(i0)))
                    # Emitting +(-(i0))
                      # Emitting -(i0)
                        # Emitting i0
                        movl -4(%ebp), %esi
                      negl %esi
                  negl %esi
              negl %esi
            addl %esi, %edi
            # Emitting -(+(-(+(-(i1)))))
              # Emitting +(-(+(-(i1))))
                # Emitting -(+(-(i1)))
                  # Emitting +(-(i1))
                    # Emitting -(i1)
                      # Emitting i1
                      movl -8(%ebp), %esi
                    negl %esi
                negl %esi
            negl %esi
          addl %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
