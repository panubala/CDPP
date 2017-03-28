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
          # Emitting i0
          subl $4, %esp
          # Emitting 5
          movl $5, %esi
        movl %esi, -4(%ebp)
        # Emitting write(+(i0))
          # Emitting +(i0)
            # Emitting i0
            movl -4(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write(-(i0))
          # Emitting -(i0)
            # Emitting i0
            movl -4(%ebp), %edi
          negl %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((-(1) * +(i0)))
          # Emitting (-(1) * +(i0))
            # Emitting -(1)
              # Emitting 1
              movl $1, %edi
            negl %edi
          pushl %edi
            # Emitting +(i0)
              # Emitting i0
              movl -4(%ebp), %edi
          movl -8(%ebp), %esi
          addl $4, %esp
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
          pushl %esi
            # Emitting -(i0)
              # Emitting i0
              movl -4(%ebp), %esi
            negl %esi
          movl -8(%ebp), %edi
          addl $4, %esp
          imull %esi, %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting i1 = 10
          # Emitting i1
          subl $4, %esp
          # Emitting 10
          movl $10, %esi
        movl %esi, -8(%ebp)
        # Emitting write((+(i0) + -(i1)))
          # Emitting (+(i0) + -(i1))
            # Emitting +(i0)
              # Emitting i0
              movl -4(%ebp), %edi
          pushl %edi
            # Emitting -(i1)
              # Emitting i1
              movl -8(%ebp), %edi
            negl %edi
          movl -12(%ebp), %esi
          addl $4, %esp
          addl %edi, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((-(i0) + -(i1)))
          # Emitting (-(i0) + -(i1))
            # Emitting -(i0)
              # Emitting i0
              movl -4(%ebp), %esi
            negl %esi
          pushl %esi
            # Emitting -(i1)
              # Emitting i1
              movl -8(%ebp), %esi
            negl %esi
          movl -12(%ebp), %edi
          addl $4, %esp
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
          pushl %edi
            # Emitting -(i1)
              # Emitting i1
              movl -8(%ebp), %edi
            negl %edi
          movl -12(%ebp), %esi
          addl $4, %esp
          addl %edi, %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting write((+(+(i0)) + -(i1)))
          # Emitting (+(+(i0)) + -(i1))
            # Emitting +(+(i0))
              # Emitting +(i0)
                # Emitting i0
                movl -4(%ebp), %esi
          pushl %esi
            # Emitting -(i1)
              # Emitting i1
              movl -8(%ebp), %esi
            negl %esi
          movl -12(%ebp), %edi
          addl $4, %esp
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
              pushl %edi
                # Emitting -(+(-(+(-(i1)))))
                  # Emitting +(-(+(-(i1))))
                    # Emitting -(+(-(i1)))
                      # Emitting +(-(i1))
                        # Emitting -(i1)
                          # Emitting i1
                          movl -8(%ebp), %edi
                        negl %edi
                    negl %edi
                negl %edi
              movl -12(%ebp), %esi
              addl $4, %esp
              addl %edi, %esi
            pushl %esi
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
            movl -12(%ebp), %edi
            addl $4, %esp
            addl %esi, %edi
          pushl %edi
            # Emitting -(+(-(+(-(i1)))))
              # Emitting +(-(+(-(i1))))
                # Emitting -(+(-(i1)))
                  # Emitting +(-(i1))
                    # Emitting -(i1)
                      # Emitting i1
                      movl -8(%ebp), %edi
                    negl %edi
                negl %edi
            negl %edi
          movl -12(%ebp), %esi
          addl $4, %esp
          addl %edi, %esi
        pushl %esi
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
